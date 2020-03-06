/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	/*config.removeDialogTabs = 'image:advanced;image:Link';//隐藏超链接与高级选项*/
        config.filebrowserImageUploadUrl = "/HmCode/Shop/upload";//上传图片的地址
        config.filebrowserHtml5videoUploadUrl = "/HmCode/Shop/uploads";//上传视频的地址
       config.extraPlugins = 'html5video';
        config.image_previewText = ' '//设置图片预览默认值为' '


};
