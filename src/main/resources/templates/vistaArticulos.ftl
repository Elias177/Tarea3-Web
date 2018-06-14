

<div class="col-12 p-2">
    <div class="row">
        <#list LosArticulos as articulo>
<div class="container">
    <div class="left-panel">
        <div class="col-xs-12 col-sm-6 col-lg-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-md-12">
                        <div class="row">
                            <h3 class="card-title">${articulo.titulo}</h3>
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                    <i class="fas fa-calendar-alt"></i> ${articulo.fecha}
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>
                <#if articulo.cuerpo?length &lt; 71>
                    <div class="panel-body">${articulo.cuerpo}
                        <a href="/articulo/${articulo.id}">Leer más...</a>
                    </div>
                <#else>
                    <div class="panel-body">${articulo.cuerpo?substring(0,70)}...
                    <a href="/articulo/${articulo.id}">Leer más...</a>
                </div>
                </#if>

                <div class="card-footer p-2">
                    <strong class="text-danger m-0">

                            <#if articulo.listaEtiqueta?size gt 0>
                               <span class="label label-default">
                                    <#list articulo.listaEtiqueta as etiqueta>
                                        ${etiqueta.etiqueta}
                                    </#list>
                               </span>
                            </#if>
                    </strong>
                </div>
            </div>
        </div>
        </#list>
    </div>
    </div>
