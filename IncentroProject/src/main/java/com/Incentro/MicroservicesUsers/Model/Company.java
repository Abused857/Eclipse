package com.Incentro.MicroservicesUsers.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_companies")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "short_description", columnDefinition = "text default null")
	private String shortDescription;
	
	@Column(name = "description", columnDefinition = "longtext default null")
	private String description;
	
	@Column(name = "url", columnDefinition = "text default null")
	private String url;
	
	@Column(name = "email", columnDefinition = "varchar(255) default null")
	private String email;
	
	@Column(name = "contact_person", columnDefinition = "varchar(255) default null")
	private String contactPerson;
	
	@Column(name = "date_start", columnDefinition = "date default null")
	private LocalDateTime dateStart;
	
	@Column(name = "date_end", columnDefinition = "date default null")
	private LocalDateTime dateEnd;
	
	@ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true)
    private File image;
	
	@Column(name = "social_login_google", columnDefinition = "boolean default 0")
	private Boolean socialLoginGoogle;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	public Company(String name, String shortDescription, String description, String url, String email, String contactPerson, LocalDateTime dateStart, LocalDateTime dateEnd, File image, Boolean socialLoginGoogle) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.url = url;
		this.email = email;
		this.contactPerson = contactPerson;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.image = image;
		this.socialLoginGoogle = socialLoginGoogle;
	}

	
	
	private void setId(Long id) {
		this.id = id;
	}



	private void setName(String name) {
		this.name = name;
	}



	private void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}



	private void setDescription(String description) {
		this.description = description;
	}



	private void setUrl(String url) {
		this.url = url;
	}



	private void setEmail(String email) {
		this.email = email;
	}



	private void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	private void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}



	private void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}



	private void setImage(File image) {
		this.image = image;
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



	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public String getEmail() {
		return email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public LocalDateTime getDateStart() {
		return dateStart;
	}

	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	public File getImage() {
		return image;
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



	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", shortDescription=" + shortDescription + ", description="
				+ description + ", url=" + url + ", email=" + email + ", contactPerson=" + contactPerson
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", image=" + image + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	
	

}
