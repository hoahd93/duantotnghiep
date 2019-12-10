/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function pagination(pageIndex, total_row){
    var html ="";
    var range = 5;
    var maxPage = Math.floor(total_row / range);
    if(total_row % range != 0)
    {
        maxPage ++;
    }
    
    var i = pageIndex - Math.floor(range/2);
    console.log(i);
    if(i  <= 0)
    {
        i = 1;
    }
    
    j = i + range - 1 ;
    
    if(j>maxPage)
    {
        j = maxPage;
    }
    
    for(i;i<=j;i++){
        if(i == pageIndex){
            html += '<li class="page-item active"><a href="javascript:;" class="page-link">'+i+'</a></li>';
        }else{
            html += '<li class="page-item"><a href="javascript:;" class="page-link">'+i+'</a></li>';
        }
    }
    
    return html;
}