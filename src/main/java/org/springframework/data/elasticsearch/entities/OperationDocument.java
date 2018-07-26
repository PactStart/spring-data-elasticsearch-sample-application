package org.springframework.data.elasticsearch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * Created by mohsinhusen on 10/04/15.
 */
@Document(indexName = "operations", type = "operation")
public class OperationDocument {

	@Id
	private Long id;

	@Field(
            type = FieldType.Text,
            index = true,
			searchAnalyzer = "standard",
            analyzer = "standard",
			store = true
	)
	private String operationName;

	@Field(
			type = FieldType.Date,
            index = true,
			store = true,
			format = DateFormat.custom, pattern = "dd.MM.yyyy hh:mm"
	)
	private Date dateUp;

	@Field(
            type = FieldType.Text,
            index = true,
			store = false
	)
	private String someTransientData;

	@Field(type = FieldType.Nested)
	private List<Sector> sectors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public Date getDateUp() {
		return dateUp;
	}

	public void setDateUp(Date dateUp) {
		this.dateUp = dateUp;
	}

	public String getSomeTransientData() {
		return someTransientData;
	}

	public void setSomeTransientData(String someTransientData) {
		this.someTransientData = someTransientData;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
}

