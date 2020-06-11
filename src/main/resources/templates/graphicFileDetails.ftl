{
	"fileNamesModel": [
		<#if (graphicFilesList)??>
			<#list graphicFilesList as fileName>
				{
					"fileName": "${fileName.fileName}",
					"fileExtension": "${fileName.fileExtension}",
					"fileContent": "${fileName.fileContent}"
				}<#sep>,
			</#list>
		</#if>
	]
}