package com.diversius.acciona.controller;

import com.diversius.acciona.controller.response.hashtag.HashtagResponse;
import com.diversius.acciona.controller.response.hashtag.HashtagResponseBuilder;
import com.diversius.acciona.useCase.hashtag.getMostUsedHashtags.GetMostUsedHashtagsOutput;
import com.diversius.acciona.useCase.hashtag.getMostUsedHashtags.GetMostUsedHashtagsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hashtag")
public class HashtagController {

    @Autowired
    private GetMostUsedHashtagsUseCase getMostUsedHashtagsUseCase;

    @GetMapping("/ranking")
    public List<HashtagResponse> getMostUsedHashtags() {
        GetMostUsedHashtagsOutput output = getMostUsedHashtagsUseCase.execute();
        return HashtagResponseBuilder.getHashtagResponses(output.getHashtags());
    }

}
