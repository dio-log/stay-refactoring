package com.dio.project.stay.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemSortType {
    GRADE("평점 순"),PRICE("낮은 가격 순"), REVIEW("댓글 많은 순");

    private String description;
}
