package xyz.stackoverflow.blog.web.controller.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import xyz.stackoverflow.blog.common.BaseController;
import xyz.stackoverflow.blog.common.BaseDTO;
import xyz.stackoverflow.blog.common.Page;
import xyz.stackoverflow.blog.common.Response;
import xyz.stackoverflow.blog.exception.BusinessException;
import xyz.stackoverflow.blog.pojo.dto.MenuDTO;
import xyz.stackoverflow.blog.pojo.po.MenuPO;
import xyz.stackoverflow.blog.service.MenuService;
import xyz.stackoverflow.blog.util.CollectionUtil;
import xyz.stackoverflow.blog.util.TransferUtil;
import xyz.stackoverflow.blog.util.ValidationUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * 菜单管理接口Controller
 *
 * @author 凉衫薄
 */
@RestController
@RequestMapping("/api/admin")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private ValidatorFactory validatorFactory;

    /**
     * 获取菜单列表 /api/admin/menu/list
     * 方法 GET
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
    public Response list(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit) {
        Response response = new Response();

        Page pageParam = new Page(Integer.valueOf(page), Integer.valueOf(limit), null);
        List<MenuPO> menus = menuService.selectByPage(pageParam);
        int count = menuService.selectByCondition(new HashMap<>()).size();

        List<MenuDTO> dtos = new ArrayList<>();
        for (MenuPO menu : menus) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setName(HtmlUtils.htmlEscape(menu.getName()));
            menuDTO.setUrl(menu.getUrl());
            if (menu.getDeleteAble() == 0) {
                menuDTO.setDeleteTag("否");
            } else {
                menuDTO.setDeleteTag("是");
            }
            dtos.add(menuDTO);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("items", dtos);
        response.setStatus(Response.SUCCESS);
        response.setMessage("菜单查询成功");
        response.setData(map);
        return response;
    }

    /**
     * 删除菜单 /api/admin/menu/delete
     * 方法 POST
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public Response delete(@RequestBody BaseDTO dto, HttpServletRequest request) {
        Response response = new Response();

        List<MenuDTO> dtos = (List<MenuDTO>) (Object) getDTO("menu", MenuDTO.class, dto);
        if (CollectionUtil.isEmpty(dtos)) {
            throw new BusinessException("找不到请求数据");
        }
        MenuDTO menuDTO = dtos.get(0);

        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MenuDTO>> violations = validator.validate(menuDTO, MenuDTO.DeleteGroup.class);
        Map<String, String> map = ValidationUtil.errorMap(violations);

        if (!CollectionUtil.isEmpty(map)) {
            throw new BusinessException("字段格式出错", map);
        }

        MenuPO menu = menuService.selectById(menuDTO.getId());

        if (menu == null) {
            throw new BusinessException("未找到该菜单或该菜单不允许删除");
        }
        if (menu.getDeleteAble() == 0) {
            throw new BusinessException("该菜单不允许被删除");
        }

        menuService.deleteById(menuDTO.getId());

        ServletContext application = request.getServletContext();
        List<MenuPO> menus = menuService.selectByCondition(new HashMap<>());
        application.setAttribute("menu", menus);

        response.setStatus(Response.SUCCESS);
        response.setMessage("删除成功");

        return response;
    }

    /**
     * 新增菜单 /api/admin/menu/insert
     * 方法 POST
     *
     * @param dto
     * @param request
     * @return
     */
    @RequestMapping(value = "/menu/insert", method = RequestMethod.POST)
    public Response insert(@RequestBody BaseDTO dto, HttpServletRequest request) {
        Response response = new Response();

        List<MenuDTO> dtos = (List<MenuDTO>) (Object) getDTO("menu", MenuDTO.class, dto);
        if (CollectionUtil.isEmpty(dtos)) {
            throw new BusinessException("找不到请求数据");
        }
        MenuDTO menuDTO = dtos.get(0);

        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MenuDTO>> violations = validator.validate(menuDTO, MenuDTO.InsertGroup.class);
        Map<String, String> map = ValidationUtil.errorMap(violations);

        if (!CollectionUtil.isEmpty(map)) {
            throw new BusinessException("字段格式出错", map);
        }

        MenuPO menu = (MenuPO) TransferUtil.dto2po(MenuPO.class, menuDTO);
        menu.setDeleteAble(1);
        menu.setDate(new Date());
        menuService.insert(menu);

        ServletContext application = request.getServletContext();
        List<MenuPO> menus = menuService.selectByCondition(new HashMap<>());
        application.setAttribute("menu", menus);

        response.setStatus(Response.SUCCESS);
        response.setMessage("菜单新增成功");

        return response;
    }

    /**
     * 更新菜单 /api/admin/menu/update
     * 方法 POST
     *
     * @param dto
     * @param request
     * @return
     */
    @RequestMapping(value = "/menu/update", method = RequestMethod.POST)
    public Response update(@RequestBody BaseDTO dto, HttpServletRequest request) {
        Response response = new Response();

        List<MenuDTO> dtos = (List<MenuDTO>) (Object) getDTO("menu", MenuDTO.class, dto);
        if (CollectionUtil.isEmpty(dtos)) {
            throw new BusinessException("找不到请求数据");
        }
        MenuDTO menuDTO = dtos.get(0);

        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MenuDTO>> violations = validator.validate(menuDTO, MenuDTO.UpdateGroup.class);
        Map<String, String> map = ValidationUtil.errorMap(violations);

        if (!CollectionUtil.isEmpty(map)) {
            throw new BusinessException("字段格式错误", map);
        }

        MenuPO menu = menuService.selectById(menuDTO.getId());

        if (menu == null) {
            throw new BusinessException("未找到该菜单");
        }
        if (menu.getDeleteAble() == 0) {
            throw new BusinessException("该菜单不允许被修改");
        }

        menuService.update((MenuPO) TransferUtil.dto2po(MenuPO.class, menuDTO));
        ServletContext application = request.getServletContext();
        List<MenuPO> menus = menuService.selectByCondition(new HashMap<>());
        application.setAttribute("menu", menus);
        response.setStatus(Response.SUCCESS);
        response.setMessage("更新成功");

        return response;
    }
}
