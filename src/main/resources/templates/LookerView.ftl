
	<div class="looker-embed-wrapper" style="width:100%; height:900px;">
		<#if secureEmbed?string=="true">
			<div id="looker-secure-message">This report is set to secure embedding. Ensure users have access to the report.</div>
			<iframe id="looker-iframe" src="${embedUrl}" width="100%" height="100%" frameborder="0" style="border:0" allowfullscreen="${allowFullScreen?if_exists?html?string!" true"}"></iframe>
			<#else>
				<!-- Public embed -->
				<iframe id="looker-iframe" src="${embedUrl}" width="100%" height="100%" frameborder="0" style="border:0" allowfullscreen="${allowFullScreen?if_exists?html?string!" true"}"></iframe>
		</#if>
	</div>
	<script>
	</script>