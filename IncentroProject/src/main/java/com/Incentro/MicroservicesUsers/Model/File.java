package com.Incentro.MicroservicesUsers.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "db_files")
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", columnDefinition = "varchar(50) default null")
	private String name;
	
	@Column(name = "size", columnDefinition = "decimal(20,5) default null")
	private BigDecimal size;
	
	@Column(name = "mimetype", columnDefinition = "varchar(50) default null")
	private String mimetype;
	
	@Column(name = "url", columnDefinition = "text default null")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "id", nullable = true)
	private FileType fileType;
	
	@ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true)
    private Company company;
	
	
	@Column(name = "private", columnDefinition = "boolean default 0")
	private Boolean filePrivate;
	
	@Column(name = "gallery", columnDefinition = "boolean default 1")
	private Boolean gallery;
	
	@Column(name = "date", columnDefinition = "date default null")
	private LocalDateTime date;
	
	@Column(name = "order", columnDefinition = "int default null")
	private Integer order;
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp on update current_timestamp")
	private LocalDateTime updatedAt;
	
	@Column (name = "deleted_at", columnDefinition = "timestamp null")
	private LocalDateTime deletedAt;
	
	
	public File(String name, BigDecimal size, String mimetype, String url, FileType fileType, Company company, Boolean filePrivate, Boolean gallery, LocalDateTime date, Integer order) {
		this.name = name;
		this.size = size;
		this.mimetype = mimetype;
		this.url = url;
		this.fileType = fileType;
		this.company = company;
		this.gallery = gallery;
		this.date = date;
		this.order = order;
	}


	private void setId(Long id) {
		this.id = id;
	}


	private void setName(String name) {
		this.name = name;
	}


	private void setSize(BigDecimal size) {
		this.size = size;
	}


	private void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}


	private void setUrl(String url) {
		this.url = url;
	}


	private void setFileType(FileType fileType) {
		this.fileType = fileType;
	}


	private void setFilePrivate(Boolean filePrivate) {
		this.filePrivate = filePrivate;
	}


	private void setGallery(Boolean gallery) {
		this.gallery = gallery;
	}


	private void setDate(LocalDateTime date) {
		this.date = date;
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


	public BigDecimal getSize() {
		return size;
	}


	public String getMimetype() {
		return mimetype;
	}


	public String getUrl() {
		return url;
	}


	public FileType getFileType() {
		return fileType;
	}


	public Boolean getFilePrivate() {
		return filePrivate;
	}


	public Boolean getGallery() {
		return gallery;
	}


	public LocalDateTime getDate() {
		return date;
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
		return "File [id=" + id + ", name=" + name + ", size=" + size + ", mimetype=" + mimetype + ", url=" + url
				+ ", fileType=" + fileType + ", filePrivate=" + filePrivate + ", gallery=" + gallery + ", date=" + date
				+ ", order=" + order + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
				+ deletedAt + "]";
	}

}
