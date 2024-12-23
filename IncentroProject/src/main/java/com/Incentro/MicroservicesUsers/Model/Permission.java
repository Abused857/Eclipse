package com.Incentro.MicroservicesUsers.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_permissions")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id", nullable = true)
    private Module module;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "description", columnDefinition = "longtext default null")
	private String description;
	
	@Column(name = "order", columnDefinition = "int default null")
	private Integer order;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	public Permission(Module module, String name, String description, Integer order) {
		this.module = module;
		this.name = name;
		this.description = description;
		this.order = order;
	}
	
	

	private void setId(Long id) {
		this.id = id;
	}



	private void setModule(Module module) {
		this.module = module;
	}



	private void setName(String name) {
		this.name = name;
	}



	private void setDescription(String description) {
		this.description = description;
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

	public Module getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
		return "Permission [id=" + id + ", module=" + module + ", name=" + name + ", description=" + description
				+ ", order=" + order + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
				+ deletedAt + "]";
	}
	
}
