-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童', '2000', '1', 'child', 'dream/child/index', 1, 0, 'C', '0', '0', 'dream:child:list', '#', 'admin', sysdate(), '', null, '儿童菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'dream:child:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'dream:child:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'dream:child:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'dream:child:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('儿童导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'dream:child:export',       '#', 'admin', sysdate(), '', null, '');