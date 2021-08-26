package com.diversius.acciona.controller;

import com.diversius.acciona.dto.HashtagDTO;
import com.diversius.acciona.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hashtag")
public class HashtagController {

    @Autowired
    private HashtagService hashtagService;

    @GetMapping("/ranking")
    public List<HashtagDTO> getMostUsedHashtags() {
        return hashtagService.getRanking();
    }

}
