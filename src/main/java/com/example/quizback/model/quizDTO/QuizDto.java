package com.example.quizback.model.quizDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class QuizDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long qid;

    private String title;
    private String description;
    private String maxMarks;
    private String noOfQuestion;
    private boolean active = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryDto categoryDto;

    @OneToMany(mappedBy = "quizDto",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<QuestionDto> questionDto = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "QuizDto{" +
                "qid=" + qid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxMarks='" + maxMarks + '\'' +
                ", noOfQuestion='" + noOfQuestion + '\'' +
                ", active=" + active +
                ", categoryDto=" + categoryDto +
                '}';
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNoOfQuestion() {
        return noOfQuestion;
    }

    public void setNoOfQuestion(String noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Set<QuestionDto> getQuestionDto() {
        return questionDto;
    }

    public void setQuestionDto(Set<QuestionDto> questionDto) {
        this.questionDto = questionDto;
    }
}
