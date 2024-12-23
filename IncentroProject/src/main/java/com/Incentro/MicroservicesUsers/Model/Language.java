package com.Incentro.MicroservicesUsers.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_languages")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(50)")
	private String name;
	
	@Column(name = "abbreviation", columnDefinition ="varchar(10)")
	private String abbreviation;
	
	@Column(name ="flag", columnDefinition ="varchar(50)")
	private String flag;
	
	@Column(name = "`order`", columnDefinition ="int")
	private Integer order;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "timestamp null")
    private LocalDateTime deletedAt;
	
    public Language(String name, String abbreviation, String flag, Integer order) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.flag = flag;
        this.order = order;
    }

	

	private void setId(Long id) {
		this.id = id;
	}



	private void setName(String name) {
		this.name = name;
	}



	private void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}



	private void setFlag(String flag) {
		this.flag = flag;
	}



	private void setOrder(Integer order) {
		this.order = order;
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



	public String getAbbreviation() {
		return abbreviation;
	}



	public String getFlag() {
		return flag;
	}



	public Integer getOrder() {
		return order;
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
		return "Language [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + ", flag=" + flag
				+ ", order=" + order + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
				+ deletedAt + "]";
	}
    
    
	
	

}
