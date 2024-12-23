package com.Incentro.MicroservicesUsers.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_gender_translations")
public class GenderTranslation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = true)
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName ="id", nullable = true)
	private Language language;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	public GenderTranslation(Gender gender, Language language, String name) {
		
		this.gender = gender;
		this.language = language;
		this.name = name;

	}

	public Long getId() {
		return id;
	}

	public Gender getGender() {
		return gender;
	}

	public Language getLanguage() {
		return language;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private void setGender(Gender gender) {
		this.gender = gender;
	}

	private void setLanguage(Language language) {
		this.language = language;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	private void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	private void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "GenderTranslation [id=" + id + ", gender=" + gender + ", language=" + language + ", name=" + name
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	
	
	
	

}
