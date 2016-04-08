<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="1.0" encoding="gb2312" />
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<body>
			
				<h2>XML转化结果</h2>
				<table border="1">
					<tr bgcolor="red">
						<th>姓名</th>
						<th>年龄</th>
						<th>地址</th>
						<th>性别</th>
						<th>身高</th>
					</tr>
					<xsl:for-each select="class/studys">
						<tr>
							<td>
								<xsl:value-of select="name" />
							</td>
							<td>
								<xsl:value-of select="age" />
							</td>
							<td>
								<xsl:value-of select="addr" />
							</td>
							<td>
								<xsl:value-of select="xingbie" />
							</td>
							<td>
								<xsl:value-of select="height" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<input type="text"  id='ss'/>sas
		</body>
		</html> 
	</xsl:template>
</xsl:stylesheet>