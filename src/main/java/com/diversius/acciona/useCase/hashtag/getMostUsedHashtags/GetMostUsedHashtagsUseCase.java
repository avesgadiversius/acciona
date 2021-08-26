package com.diversius.acciona.useCase.hashtag.getMostUsedHashtags;

import com.diversius.acciona.dto.HashtagDTO;
import com.diversius.acciona.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMostUsedHashtagsUseCase {

    @Autowired
    private HashtagService hashtagService;

    public GetMostUsedHashtagsOutput execute() {
        List<HashtagDTO> hashtags = hashtagService.getRanking();

        return new GetMostUsedHashtagsOutput(hashtags);
    }
}
