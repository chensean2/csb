package com.csb.core.model;

import javax.persistence.*;

@Table(name = "csb_app_category_package")
public class AppCategoryPackage {
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "package_id")
    private Long packageId;

    /**
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return package_id
     */
    public Long getPackageId() {
        return packageId;
    }

    /**
     * @param packageId
     */
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}