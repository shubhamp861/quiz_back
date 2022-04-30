package com.example.quizback.model.quizDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "CategoryDto")
public class CategoryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long cid;

    private String title;
    private String description;

    @OneToMany(mappedBy = "categoryDto",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<QuizDto> quizDtoLinkedHashSet = new LinkedHashSet<>();

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Set<QuizDto> getQuizDtoLinkedHashSet() {
        return quizDtoLinkedHashSet;
    }

    public void setQuizDtoLinkedHashSet(Set<QuizDto> quizDtoLinkedHashSet) {
        this.quizDtoLinkedHashSet = quizDtoLinkedHashSet;
    }

    public CategoryDto() {
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
