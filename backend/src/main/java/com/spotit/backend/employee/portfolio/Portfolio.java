package com.spotit.backend.employee.portfolio;

import static jakarta.persistence.FetchType.EAGER;

import java.util.List;

import com.spotit.backend.employee.abstraction.AbstractEntity;
import com.spotit.backend.employee.userAccount.UserAccount;
import com.spotit.backend.employee.userDetails.course.Course;
import com.spotit.backend.employee.userDetails.education.Education;
import com.spotit.backend.employee.userDetails.experience.Experience;
import com.spotit.backend.employee.userDetails.foreignLanguage.ForeignLanguage;
import com.spotit.backend.employee.userDetails.interest.Interest;
import com.spotit.backend.employee.userDetails.project.Project;
import com.spotit.backend.employee.userDetails.social.Social;
import com.spotit.backend.employee.userDetails.softSkill.SoftSkill;
import com.spotit.backend.employee.userDetails.techSkill.TechSkill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Portfolio extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String portfolioUrl;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Course> courses;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Education> educations;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Experience> experiences;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Interest> interests;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Project> projects;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<Social> socials;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<SoftSkill> softSkills;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private List<TechSkill> techSkills;

    @Override
    public void update(AbstractEntity otherEntity) {
        if (otherEntity instanceof Portfolio o) {
            if (o.portfolioUrl != null) {
                portfolioUrl = o.portfolioUrl;
            }
        }
    }
}
