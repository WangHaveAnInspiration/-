-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品', '2000', '1', 'prize', 'dream/prize/index', 1, 0, 'C', '0', '0', 'dream:prize:list', '#', 'admin', sysdate(), '', null, '奖品菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'dream:prize:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'dream:prize:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'dream:prize:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'dream:prize:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'dream:prize:export',       '#', 'admin', sysdate(), '', null, '');