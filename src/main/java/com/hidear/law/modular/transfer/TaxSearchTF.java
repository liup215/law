package com.hidear.law.modular.transfer;

/**
 * Created by Administrator on 2017/7/15.
 */
public class TaxSearchTF {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortColumn;
    private String sortType;

    private String contactAddress;
    private String workSpace;

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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(String workSpace) {
        this.workSpace = workSpace;
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

    public TaxSearchTF() {
    }

    public TaxSearchTF(Integer pageNumber, Integer pageSize, String sortColumn, String sortType, String contactAddress, String workSpace, Integer scaleMin, Integer scaleMax, Double assetsMin, Double assetsMax, Double outputMin, Double outputMax, Integer workType, Integer post, Long updateTimeMin, Long updateTimeMax, Integer status) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortColumn = sortColumn;
        this.sortType = sortType;
        this.contactAddress = contactAddress;
        this.workSpace = workSpace;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
        this.assetsMin = assetsMin;
        this.assetsMax = assetsMax;
        this.outputMin = outputMin;
        this.outputMax = outputMax;
        this.workType = workType;
        this.post = post;
        this.updateTimeMin = updateTimeMin;
        this.updateTimeMax = updateTimeMax;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaxSearchTF{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortColumn='" + sortColumn + '\'' +
                ", sortType='" + sortType + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", workSpace='" + workSpace + '\'' +
                ", scaleMin=" + scaleMin +
                ", scaleMax=" + scaleMax +
                ", assetsMin=" + assetsMin +
                ", assetsMax=" + assetsMax +
                ", outputMin=" + outputMin +
                ", outputMax=" + outputMax +
                ", workType=" + workType +
                ", post=" + post +
                ", updateTimeMin=" + updateTimeMin +
                ", updateTimeMax=" + updateTimeMax +
                ", status=" + status +
                '}';
    }
}
