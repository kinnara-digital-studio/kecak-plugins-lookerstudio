<style>
#looker-report-name{
    font-size: 22px;
    font-weight: 600;
    margin-bottom: 12px;
    color: #2c3e50;
}
</style>
<div class="looker-embed-wrapper" style="width:100%; height:900px;">
    <div id="looker-report-name">${reportName}</div>
	<iframe id="looker-iframe" src="${embedUrl}" width="100%" height="100%" frameborder="0" style="border:0"></iframe>
</div>