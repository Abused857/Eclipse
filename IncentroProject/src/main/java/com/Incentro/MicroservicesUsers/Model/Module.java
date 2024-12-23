package com.Incentro.MicroservicesUsers.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_modules")
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "order", columnDefinition = "int default null")
	private Integer order;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	public Module(String name, Integer order) {
		this.name = name;
		this.order = order;
	}
	
	

	private void setId(Long id) {
		this.id = id;
	}



	private void setName(String name) {
		this.name = name;
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
		return "Module [id=" + id + ", name=" + name + ", order=" + order + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	

}
