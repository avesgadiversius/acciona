package com.diversius.acciona.service;

import com.diversius.acciona.dto.HashtagDTO;
import com.diversius.acciona.entity.Hashtag;

import java.util.List;

public interface HashtagService {

    void save(Hashtag hashtag);

    Hashtag createHashtag(String text);

    Hashtag getHashtagByText(String text);

    List<HashtagDTO> getRanking();

}
