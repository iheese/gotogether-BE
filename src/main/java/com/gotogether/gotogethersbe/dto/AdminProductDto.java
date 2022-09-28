package com.gotogether.gotogethersbe.dto;

import com.gotogether.gotogethersbe.domain.Option;
import com.gotogether.gotogethersbe.domain.Product;
import com.gotogether.gotogethersbe.domain.enums.*;
import lombok.Getter;

import java.util.List;

public class AdminProductDto {

    @Getter
    public static class ProductRequest{
        private Long id;
        private String thumbnail;
        private String productName;
        private long amount;
        private String info;
        private String country;
        private Continent continent;
        private List<OptionDto.OptionRequest> optionDtoList;

        //요약 정보
        private String region;
        private String airport;
        private String points;

        //추천 데이터
        private String ages;
        private Companion companion;
        private GenderGroup genderGroup;
        private Religion religion;
        private Theme theme;

        public Product toProduct(List<Option> optionList){
            return Product.builder()
                    .id(id)
                    .thumbnail(thumbnail)
                    .productName(productName)
                    .amount(amount)
                    .info(info)
                    .country(country)
                    .continent(continent)
                    .optionList(optionList)
                    .region(region)
                    .airport(airport)
                    .points(points)
                    .ages(ages)
                    .companion(companion)
                    .genderGroup(genderGroup)
                    .religion(religion)
                    .theme(theme)
                    .build();
        }
    }

    @Getter
    public static class ProductResponse{
        private Long id;
        private String thumbnail;
        private String productName;
        private long amount;
        private String info;
        private String country;
        private Continent continent;
        private List<OptionDto.OptionResponse> optionDtoList;

        //요약 데이터
        private String region;
        private String airport;
        private String points;

        //추천 데이터
        private String ages;
        private Companion companion;
        private GenderGroup genderGroup;
        private Religion religion;
        private Theme theme;

        public ProductResponse(Product product, List<OptionDto.OptionResponse> optionDtoList ) {
            this.id = product.getId();
            this.thumbnail = product.getThumbnail();
            this.productName = product.getProductName();
            this.amount = product.getAmount();
            this.info = product.getInfo();
            this.country = product.getCountry();
            this.continent = product.getContinent();
            this.optionDtoList = optionDtoList;
            //요약 데이터
            this.ages = product.getRegion();
            this.airport = product.getAirport();
            this.points = product.getPoints();
            //추천데이터
            this.ages = product.getAges();
            this.companion = product.getCompanion();
            this.genderGroup = product.getGenderGroup();
            this.religion = product.getReligion();
            this.theme = product.getTheme();
        }
    }

    public static class ProductListResponse{
        private Long id;
        private String productName;

        public ProductListResponse(Product product){
            this.id = product.getId();
            this.productName = product.getProductName();
        }
    }
}
