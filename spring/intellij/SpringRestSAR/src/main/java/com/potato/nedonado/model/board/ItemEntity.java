package com.potato.nedonado.model.board;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ItemEntity {

    @NotEmpty
    private long boardIdx;
    private int boardCategory;

    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private int category;
    private String thumbnail;
    private String imgURL;
    @NotEmpty
    private int onSale;
    @NotEmpty
    private int price;
    @NotEmpty
    private long userIdx;
    @NotEmpty
    private long writeDate;

    public ItemViewListInfo toItemViewInfo(){
        return null;
    }

}
