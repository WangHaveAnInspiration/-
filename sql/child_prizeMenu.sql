-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表', '2000', '1', 'child_prize', 'dream/child_prize/index', 1, 0, 'C', '0', '0', 'dream:child_prize:list', '#', 'admin', sysdate(), '', null, '奖品兑换信息表菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'dream:child_prize:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'dream:child_prize:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'dream:child_prize:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'dream:child_prize:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('奖品兑换信息表导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'dream:child_prize:export',       '#', 'admin', sysdate(), '', null, '');