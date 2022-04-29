-- 邮件菜单配置
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'mail-manage/config' WHERE `id` = 8;
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'mail-manage/template' WHERE `id` = 9;
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'mail-manage/history' WHERE `id` = 10;

-- 短信菜单配置
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'sms-manage/config' WHERE `id` = 12;
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'sms-manage/template' WHERE `id` = 13;
UPDATE `fallplatform`.`s_menu` SET `func_link` = 'sms-manage/history' WHERE `id` = 14;

