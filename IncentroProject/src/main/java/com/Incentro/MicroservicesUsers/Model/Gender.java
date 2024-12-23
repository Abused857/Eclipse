package com.Incentro.MicroservicesUsers.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_genders")
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default cureent_timestamp on update current_timestamp")
	private LocalDateTime updateAt;
	
	@Column(name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;

	

	private void setId(Long id) {
		this.id = id;
	}



	private void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}



	private void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}



	private void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}



	public Long getId() {
		return id;
	}



	public LocalDateTime getCreateAt() {
		return createAt;
	}



	public LocalDateTime getUpdateAt() {
		return updateAt;
	}



	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}



	@Override
	public String toString() {
		return "Gender [id=" + id + ", createAt=" + createAt + ", updateAt=" + updateAt + ", deletedAt=" + deletedAt
				+ "]";
	}
	
	

}
