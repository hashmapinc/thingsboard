/**
 * Copyright © 2016-2017 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data;

import org.thingsboard.server.common.data.id.*;

import java.util.HashSet;
import java.util.Set;

public class Application extends SearchTextBased<ApplicationId> implements HasName {

    private static final long serialVersionUID = 1533755382827939542L;

    private TenantId tenantId;
    private CustomerId customerId;
    private DashboardId dashboardId;
    private DashboardId miniDashboardId;
    private Set<RuleId> rules = new HashSet<>();
    private String name;
    private String description;
    private Set<String> deviceTypes = new HashSet<>();
    private Boolean isValid = Boolean.TRUE;

    public Application() {
        super();
    }

    public Application(ApplicationId id) {
        super(id);
    }

    public Application(Application application) {
        super(application);
        this.tenantId = application.tenantId;
        this.customerId = application.customerId;
        this.dashboardId = application.dashboardId;
        this.miniDashboardId = application.miniDashboardId;
        this.rules = application.rules;
        this.name = application.name;
        this.description = application.description;
        this.deviceTypes = application.deviceTypes;
        this.isValid = application.isValid;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSearchText() {
        return name;
    }

    public DashboardId getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(DashboardId dashboardId) {
        this.dashboardId = dashboardId;
    }

    public DashboardId getMiniDashboardId() {
        return miniDashboardId;
    }

    public void setMiniDashboardId(DashboardId miniDashboardId) {
        this.miniDashboardId = miniDashboardId;
    }

    public Set<RuleId> getRules() {
        return rules;
    }

    public void setRules(Set<RuleId> rules) {
        this.rules = rules;
    }

    public void addRules(Set<RuleId> rules) {
        this.rules.addAll(rules);
    }

    public void addDeviceTypes(Set<String> deviceTypes) {
        this.deviceTypes.addAll(deviceTypes);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(Set<String> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public TenantId getTenantId() {
        return tenantId;
    }

    public void setTenantId(TenantId tenantId) {
        this.tenantId = tenantId;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Application{" +
                "tenantId=" + tenantId +
                ", customerId=" + customerId +
                ", miniDashboardId=" + miniDashboardId +
                ", dashboardId=" + dashboardId +
                ", isValid=" + isValid +
                ", rules=" + rules +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deviceTypes=" + deviceTypes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Application that = (Application) o;

        if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (dashboardId != null ? !dashboardId.equals(that.dashboardId) : that.dashboardId != null) return false;
        if (miniDashboardId != null ? !miniDashboardId.equals(that.miniDashboardId) : that.miniDashboardId != null)
            return false;
        if (rules != null ? !rules.equals(that.rules) : that.rules != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (deviceTypes != null ? !deviceTypes.equals(that.deviceTypes) : that.deviceTypes != null) return false;
        return isValid != null ? isValid.equals(that.isValid) : that.isValid == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (dashboardId != null ? dashboardId.hashCode() : 0);
        result = 31 * result + (miniDashboardId != null ? miniDashboardId.hashCode() : 0);
        result = 31 * result + (rules != null ? rules.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (deviceTypes != null ? deviceTypes.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
