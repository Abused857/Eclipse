package com.Incentro.MicroservicesUsers.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_settings")
public class Setting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true)
    private Company company;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "value", columnDefinition = "varchar(50) default null")
	private String value;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	public Setting(Company company, String name, String value) {
		this.company = company;
		this.name = name;
		this.value = value;
	}
	
	

	private void setId(Long id) {
		this.id = id;
	}



	private void setCompany(Company company) {
		this.company = company;
	}



	private void setName(String name) {
		this.name = name;
	}



	private void setValue(String value) {
		this.value = value;
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

	public Company getCompany() {
		return company;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
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
		return "Setting [id=" + id + ", company=" + company + ", name=" + name + ", value=" + value + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	
	
	

	
	
	
	
	

}
