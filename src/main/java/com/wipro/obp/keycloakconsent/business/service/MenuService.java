package com.wipro.obp.keycloakconsent.business.service;


import com.wipro.obp.keycloakconsent.business.domain.MenuDto;

import com.wipro.obp.keycloakconsent.data.entity.Menu;
import com.wipro.obp.keycloakconsent.data.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class MenuService extends BaseService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDto> findMenu() {

        CurrentUser cu = getCurrentUser();

        List<Menu> unorderedMenus = menuRepository.findMenuByRoles(cu.getRoles());
        List<MenuDto> parentMenuDtos = unorderedMenus.stream().filter(e -> e.getParentMenu() == null).map(MenuDto::new).collect(Collectors.toList());

        parentMenuDtos = parentMenuDtos.stream().map(e -> {
            e.setSubMenus(unorderedMenus.stream().filter(sm -> sm.getParentMenu() != null && sm.getParentMenu().getId().equals(e.getId())).sorted().map(MenuDto::new)
                    .collect(Collectors.toList()));
            return e;
        }).collect(Collectors.toList());

        return parentMenuDtos;
    }
}
