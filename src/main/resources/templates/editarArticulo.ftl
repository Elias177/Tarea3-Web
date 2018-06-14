
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel-group">
                <div class="panel panel-primary">
                    <div class="panel-heading">

                        <form class="col-11 py-5" method="post" action="/editar/${articulo.id}">
                            <div class="panel px-2 py-3 bg-white">

                                <label for="titulo"><strong>Titulo</strong> </label>
                                <input type="text" class="form-control rounded-0" name="titulo" value="${articulo.titulo}"/>

                                <label for="cuerpo"><strong>Cuerpo</strong></label><br>
                                <textarea name="cuerpo" class="form-control rounded-0">${articulo.cuerpo}</textarea>

                                <label for="etiquetas"><strong>Etiquetas</strong></label>
                                <textarea name="etiquetas" class="form-control rounded-0">

                            <#list articulo.listaEtiquetas as etiqueta>${etiqueta.etiqueta},</#list>
                                </textarea>
                            </div>
                            <button class="btn btn-light" type="submit">
                                EDITAR
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
