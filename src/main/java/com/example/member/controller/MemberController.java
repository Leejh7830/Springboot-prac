package com.example.member.controller;

import com.example.member.dto.MemberFormDto;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("findall")
    public String findall(Model model, @RequestParam int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<Member> list = memberRepository.findAll(pageable);



        model.addAttribute("list",list);
        return "member/findall";
    }

    @GetMapping("insert")
    public String insert(Model model) {
        model.addAttribute("memberFormDto",new MemberFormDto());
        return "member/insert";
    }

    @PostMapping("insert")
    public String insert(Model model, @Valid MemberFormDto memberFormDto, BindingResult bindingResult) {
        Member member = Member.createMember(memberFormDto);
        System.out.println(member);
        // 에러가 있으면 insert로 이동
        if(bindingResult.hasErrors()) {
            return "member/insert";
        }
        // 에러없으면 저장,findall로 이동
        memberRepository.save(member);
        return "redirect:findall";
    }

    @GetMapping("update")
    public String insert(Model model, @RequestParam("id") Long id) {
        System.out.println("id : " + id);
        Member mdf = memberRepository.findById(id).orElse(new Member());
        model.addAttribute("memberFormDto",new MemberFormDto(mdf.getId(),
                mdf.getEmail(),mdf.getName(), mdf.getGender(), mdf.getPassword()));
        return "member/update";
    }

    @PostMapping("update")
    public String update(Model model, @Valid MemberFormDto memberFormDto, BindingResult bindingResult) {
        Member member = Member.createMember(memberFormDto);
        System.out.println(member);
        // 에러가 있으면 insert로 이동
        if(bindingResult.hasErrors()) {
            return "member/update";
        }
        // id값을 확인해서 insert,save 구분
        memberRepository.save(member);
        // 에러없으면 저장,findall로 이동
        return "redirect:findall";
    }

    @PostMapping("delete")
    public String delete(Long[] id) {
        for (Long temp:id) {
            System.out.println(temp);
        }
        List<Long> list = Arrays.asList(id);
        list.forEach(System.out::println);
        memberRepository.deleteAllById(list);
        return "redirect:findall";
    }
}
