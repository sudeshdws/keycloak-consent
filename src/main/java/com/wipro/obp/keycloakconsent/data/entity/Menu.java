/**
 * An Open Source Inventory and Sales Management System
 * Copyright (C) 2019 Edward P. Legaspi (https://github.com/czetsuya)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.wipro.obp.keycloakconsent.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "iam_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity implements Comparable<Menu> {

    private static final long serialVersionUID = -2112068280721667149L;

    @ManyToOne
    @JoinColumn(name = "parent_menu_id")
    private Menu parentMenu;

    @Column(name = "label")
    private String label;

    @Column(name = "icon")
    private String icon;

    @Column(name = "sort_order")
    private int sortOrder;

    @Column(name = "route")
    private String route;

    @Column(name = "role")
    @ElementCollection
    @CollectionTable(name = "role_menus", joinColumns = @JoinColumn(name = "menu_id"))
    private List<String> roles;

    @Override
    public int compareTo(Menu o) {
        return sortOrder - o.getSortOrder();
    }
}
