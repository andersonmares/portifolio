<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Formulário de Projeto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Cadastro de Projeto</h1>
    <form:form method="post" modelAttribute="projeto" class="form">
        <div class="form-group">
            <label for="nome">Nome</label>
            <form:input path="nome" class="form-control" id="nome"/>
        </div>
        <div class="form-group">
            <label for="descricao">Descrição</label>
            <form:textarea path="descricao" class="form-control" id="descricao"/>
        </div>
        <div class="form-group">
            <label for="gerente">Gerente</label>
            <form:select path="gerente.id" class="form-control" id="gerente">
                <form:options items="${gerenteList}" itemValue="id" itemLabel="nome"/>
            </form:select>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <form:select path="status" class="form-control" id="status">
                <form:options items="${statusList}"/>
            </form:select>
        </div>
        <div class="form-group">
            <label for="dataInicio">Data de Início</label>
            <form:input path="dataInicio" class="form-control" id="dataInicio" type="date"/>
        </div>
        <div class="form-group">
            <label for="dataPrevisaoFim">Data Previsão Fim</label>
            <form:input path="dataPrevisaoFim" class="form-control" id="dataPrevisaoFim" type="date"/>
        </div>
        <div class="form-group">
            <label for="orcamento">Orçamento</label>
            <form:input path="orcamento" class="form-control" id="orcamento" type="number" step="0.01"/>
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form:form>
</div>
</body>
</html>