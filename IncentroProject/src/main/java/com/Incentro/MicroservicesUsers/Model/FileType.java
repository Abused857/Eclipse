package com.Incentro.MicroservicesUsers.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_file_types")
public class FileType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "extensions", columnDefinition = "text default null")
	private String extensions;
	
	@Column(name = "max_size", columnDefinition = "bigint default null")
	private Long maxSize;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
public FileType(String name, String extensions, Long maxSize) {
		
		this.name = name;
		this.extensions = extensions;
		this.maxSize = maxSize;

	}


private void setId(Long id) {
	this.id = id;
}


private void setName(String name) {
	this.name = name;
}


private void setExtensions(String extensions) {
	this.extensions = extensions;
}


private void setMaxSize(Long maxSize) {
	this.maxSize = maxSize;
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

public String getExtensions() {
	return extensions;
}

public Long getMaxSize() {
	return maxSize;
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
	return "FileType [id=" + id + ", name=" + name + ", extensions=" + extensions + ", maxSize=" + maxSize
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
}
	

	

}
