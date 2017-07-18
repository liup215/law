package com.hidear.law.modular.transfer;

/**
 * Created by Administrator on 2017/7/17.
 */
public class LawSearchTF {

    /**
     * 页数
     */
    private Integer pageNumber;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 排序字段
     */
    private String sortColumn;
    /**
     * 排序类型，ASC升序，DESC降序
     */
    private String sortType;
    /**
     * 联系地址，格式：省-市-区县-乡镇街道
     */
    private String contactAddress;
    /**
     * 被告所在地，格式：省-市-区县-乡镇街道
     */
    private String accusedArea;
    /**
     * 合同签约地，格式：省-市-区县-乡镇街道
     */
    private String contractArea;
    /**
     * 案发地，格式：省-市-区县-乡镇街道
     */
    private String venueArea;
    /**
     * 案件类型
     */
    private Integer caseType;
    /**
     * 工作类型，0兼职，1全职
     */
    private Integer workType;

    /**
     * 更新时间-开始
     */
    private Long updateTimeMin;
    /**
     * 更新时间-结束
     */
    private Long updateTimeMax;
    /**
     * 状态
     */
    private Integer status;

    public LawSearchTF() {
    }

    @Override
    public String toString() {
        return "LawSearchTF{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortColumn='" + sortColumn + '\'' +
                ", sortType='" + sortType + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", accusedArea='" + accusedArea + '\'' +
                ", contractArea='" + contractArea + '\'' +
                ", venueArea='" + venueArea + '\'' +
                ", caseType=" + caseType +
                ", workType=" + workType +
                ", updateTimeMin=" + updateTimeMin +
                ", updateTimeMax=" + updateTimeMax +
                ", status=" + status +
                '}';
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getAccusedArea() {
        return accusedArea;
    }

    public void setAccusedArea(String accusedArea) {
        this.accusedArea = accusedArea;
    }

    public String getContractArea() {
        return contractArea;
    }

    public void setContractArea(String contractArea) {
        this.contractArea = contractArea;
    }

    public String getVenueArea() {
        return venueArea;
    }

    public void setVenueArea(String venueArea) {
        this.venueArea = venueArea;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
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

    public LawSearchTF(Integer pageNumber, Integer pageSize, String sortColumn, String sortType, String contactAddress, String accusedArea, String contractArea, String venueArea, Integer caseType, Integer workType, Long updateTimeMin, Long updateTimeMax, Integer status) {

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortColumn = sortColumn;
        this.sortType = sortType;
        this.contactAddress = contactAddress;
        this.accusedArea = accusedArea;
        this.contractArea = contractArea;
        this.venueArea = venueArea;
        this.caseType = caseType;
        this.workType = workType;
        this.updateTimeMin = updateTimeMin;
        this.updateTimeMax = updateTimeMax;
        this.status = status;
    }
}
