import React from 'react';

const ProductInsert = () => {
    return (
        <div>
		    <h4>
			    <i class="fa fa-angle-right"></i> 상품등록
		    </h4>
		    <hr/>
		    <div class="row mt">
			    <div class="col-lg-12">
				    <div class="form-panel">
				
					    <form class="form-horizontal style-form" >
						    <div class="form-group" style="border: 1px solid #eff2f7;">

							    <label class="col-sm-2 col-sm-2 control-label" >작성자</label>
							    <div class="col-sm-10" >

								    <p class="form-control-static" th:text="${'admin'}" th:unless="${user!=null}"></p>
							    </div>
							    <div class="form-group">
								    <label class="col-sm-2 col-sm-2 control-label">카테고리</label>
	
								    <div class="col-sm-5">
									    <select name="category" class="form-control" >
										    <option  th:each="category:${categorylist}"
												    th:value="${category.categoryId}"
												    name="category" th:text="${category.categoryName}"></option>

									    </select>
								    </div>
							    </div>
							    <div class="form-group">
								    <label class="col-sm-2 col-sm-2 control-label">상품명</label>
								    <div class="col-sm-8">
									    <input type="text" class="form-control"
											    name="productName"/>
									    <span class="help-block">내용으로 작성 부탁드립니다. </span>
								    </div>
							    </div>
							    <div class="form-group">
								    <label class="col-sm-2 col-sm-2 control-label">가격</label>
								    <div class="col-sm-8">
									    <input type="text" class="form-control"
										    name="price"/>
									    <span class="help-block">내용으로 작성 부탁드립니다. </span>
								    </div>
							    </div>
							    <div class="form-group">
								    <label class="col-sm-2 col-sm-2 control-label">이미지명</label>
								    <div class="col-sm-8">
									    <input type="text" class="form-control"
										    name="image"/>
									    <span class="help-block">내용으로 작성 부탁드립니다. </span>
								    </div>
							    </div>
							    <div class="form-group">
								    <label class="col-sm-2 col-sm-2 control-label">비고</label>
								    <div class="col-sm-8">
									    <textarea id="content"
										    // eslint-disable-next-line react/style-prop-object
										    style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
										    name="info">상품에대한 설명을 작성하세요</textarea>
	
								    </div>
							    </div>
							    <div class="form-group">
								    <div class="col-lg-4 text-center"></div>
								    <div class="col-lg-2 text-center">
									    <button type="submit" class="btn btn-success"
										    // eslint-disable-next-line react/style-prop-object
										    style="width: 100px; background-color: #0ea006">등록</button>
								    </div>
								    <div class="col-lg-2 text-center">
									    <button type="reset" class="btn btn-default"
										    // eslint-disable-next-line react/style-prop-object
										    style="width: 100px; background-color: #9a9a9a">취소</button>
								    </div>
							
							    </div>
						    </div>
					    </form>
				    </div>
			    </div>
            </div>
        </div>
    );
};

export default ProductInsert;