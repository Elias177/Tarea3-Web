

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
                            <h3 class="card-title">${articulo.eltitulo}</h3>
                            <div class="col-sm-3">
                                <h4 class="pull-right">
                                    <i class="fas fa-calendar-alt"></i> ${articulo.lafecha}
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel-body">${articulo.bodydelart}
                    <a href="/articulo/${articulo.id}">Leer más...</a>
                </div>
                <div class="card-footer p-2">
                    <strong class="text-danger m-0">

                            <span class="text-success ml-5">
                                <p>Comentarios ${articulo.listadeComments?size} </p>
                            </span>
                            <#if articulo.listadeEtiquetas?size gt 0>
                               <span class="label label-default">
                                    <#list articulo.listadeEtiquetas as etiqueta>
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
