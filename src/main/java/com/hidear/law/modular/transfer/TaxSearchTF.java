package com.hidear.law.modular.transfer;

/**
 * Created by Administrator on 2017/7/15.
 */
public class TaxSearchTF {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortColumn;
    private String sortType;

    private String province;
    private String city;
    private String town;
    private String county;

    private Integer scaleMin;
    private Integer scaleMax;

    private Double assetsMin;
    private Double assetsMax;

    private Double outputMin;
    private Double outputMax;

    private Integer workType;
    private Integer post;

    private Long updateTimeMin;
    private Long updateTimeMax;

    private Integer status;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getScaleMin() {
        return scaleMin;
    }

    public void setScaleMin(Integer scaleMin) {
        this.scaleMin = scaleMin;
    }

    public Integer getScaleMax() {
        return scaleMax;
    }

    public void setScaleMax(Integer scaleMax) {
        this.scaleMax = scaleMax;
    }

    public Double getAssetsMin() {
        return assetsMin;
    }

    public void setAssetsMin(Double assetsMin) {
        this.assetsMin = assetsMin;
    }

    public Double getAssetsMax() {
        return assetsMax;
    }

    public void setAssetsMax(Double assetsMax) {
        this.assetsMax = assetsMax;
    }

    public Double getOutputMin() {
        return outputMin;
    }

    public void setOutputMin(Double outputMin) {
        this.outputMin = outputMin;
    }

    public Double getOutputMax() {
        return outputMax;
    }

    public void setOutputMax(Double outputMax) {
        this.outputMax = outputMax;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Long getUpdateTimeMin() {
        return updateTimeMin;
    }

    public void setUpdateTimeMin(Long updateTimeMin) {
        this.updateTimeMin = updateTimeMin;
    }

    public Long getUpdateTimeMax() {
        return updateTimeMax;
    }

    public void setUpdateTimeMax(Long updateTimeMax) {
        this.updateTimeMax = updateTimeMax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
