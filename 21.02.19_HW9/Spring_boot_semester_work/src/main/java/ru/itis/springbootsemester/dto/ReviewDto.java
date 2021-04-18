package ru.itis.springbootsemester.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springbootsemester.models.Review;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ReviewDto {
    private Integer id;
    private Date date;
    private Long filmId;
    private String filmTitle;
    private String filmPosterPath;
    private String text;
    private Byte rating;

    public static ReviewDto from(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .date(review.getDate())
                .filmId(review.getFilm().getId())
                .filmTitle(review.getFilm().getTitle())
                .filmPosterPath(review.getFilm().getPoster().getStorageName())
                .text(review.getText())
                .rating(review.getRating())
                .build();
    }

    public static List<ReviewDto> from(List<Review> reviews) {
        return reviews.stream().map(ReviewDto::from).collect(Collectors.toList());
    }
}
