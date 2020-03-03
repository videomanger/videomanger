/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.base.auth.model;

import cn.stylefeng.roses.core.util.ToolUtil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
 * 当前登录用户信息
 *
 * @author fengshuonan
 * @Date 2019/7/18 22:29
 */
@Data
public class LoginUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 角色集
     */
    private List<Long> roleList;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色名称集
     */
    private List<String> roleNames;

    /**
     * 角色备注（code）
     */
    private List<String> roleTips;

    /**
     * 系统标识集合
     */
    private List<Map<String, Object>> systemTypes;

    /**
     * 拥有的权限
     */
    private Set<String> permissions;

    /**
     * 租户编码
     */
    private String tenantCode;

    /**
     * 租户的数据源名称
     */
    private String tenantDataSourceName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (ToolUtil.isNotEmpty(this.roleNames)) {
            for (String roleName : this.roleNames) {
                GrantedAuthority grantedAuthority = (GrantedAuthority) () -> roleName;
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        //能生成loginUser就是jwt解析成功，没锁定
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //能生成loginUser就是jwt解析成功，没锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //能生成loginUser就是jwt解析成功，没锁定
        return true;
    }

    @Override
    public boolean isEnabled() {
        //能生成loginUser就是jwt解析成功，没锁定
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public List<Long> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Long> roleList) {
        this.roleList = roleList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public List<String> getRoleTips() {
        return roleTips;
    }

    public void setRoleTips(List<String> roleTips) {
        this.roleTips = roleTips;
    }

    public List<Map<String, Object>> getSystemTypes() {
        return systemTypes;
    }

    public void setSystemTypes(List<Map<String, Object>> systemTypes) {
        this.systemTypes = systemTypes;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getTenantDataSourceName() {
        return tenantDataSourceName;
    }

    public void setTenantDataSourceName(String tenantDataSourceName) {
        this.tenantDataSourceName = tenantDataSourceName;
    }
}
