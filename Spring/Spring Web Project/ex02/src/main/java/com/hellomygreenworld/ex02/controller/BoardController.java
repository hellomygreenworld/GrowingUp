package com.hellomygreenworld.ex02.controller;

import com.hellomygreenworld.ex02.domain.BoardVO;
import com.hellomygreenworld.ex02.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;
    
    @GetMapping("/list")
    public void list(Model model) {
        log.info("=== list ===");
        model.addAttribute("list", boardService.getList());
    }

    @GetMapping("register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("=== register: " + boardVO + " ===");
        boardService.register(boardVO);
        rttr.addFlashAttribute("result", boardVO.getBno());

        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(@RequestParam("bno") int bno, Model model) {
        log.info("=== get ===");
        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, RedirectAttributes rttr) {
        log.info("=== modify: " + boardVO + " ===");
        if(boardService.modify(boardVO))
            rttr.addFlashAttribute("result", "success");
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) {
        log.info("=== remove === ");
        if (boardService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

}