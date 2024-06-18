package com.example.back.dto.object;


import com.example.back.repository.resultSet.GetReviewListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListItem {

    private String nickname;
    private String writeDatetime;
    private String content;

    public ReviewListItem(GetReviewListResultSet resultSet){
        this.writeDatetime = resultSet.getWriteDatetime();
        this.content = resultSet.getContent();
    }

    public static List<ReviewListItem> copyList(List<GetReviewListResultSet> resultSets){
        List<ReviewListItem> list = new ArrayList<>();
        for(GetReviewListResultSet resultSet: resultSets){
            ReviewListItem reviewListItem = new ReviewListItem(resultSet);
            list.add(reviewListItem);
        }
        return list;
    }
}
