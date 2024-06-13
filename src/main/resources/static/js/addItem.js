//複数画像選択

 		// 選択した画像ファイルのプレビューを生成する関数を定義します。
        function preview(obj) {
            const element = document.getElementsByClassName('sampleImage'); 
			while (element.length) {
 				 element.item(0).remove()
			}
            // 選択した全てのファイルに対してループ処理をします。
            for (i = 0; i < obj.files.length; i++) {
                // FileReaderオブジェクトを作成します。これによりブラウザ上でファイルを読み込むことが可能になります。
                let fileReader = new FileReader();
                // onloadイベントハンドラを設定します。ファイルが正常に読み込まれたときに呼び出されます。
                fileReader.onload = ((e)=> {
                    // 読み込んだ画像ファイルをData URLとしてimg要素に設定します。
                    // これにより、選択した画像がブラウザ上でプレビュー表示されます。
                    document.querySelector('.img').innerHTML += '<img src="' + e.target.result + '" class="sampleImage">';
                });
                // ファイルをData URLとして読み込みます。
                fileReader.readAsDataURL(obj.files[i]);
                //ボタンを活性化
            }
			if(obj.files.length){
				const button = document.getElementById("submitButton");
				button.disabled = null;
			}else {
				button.disabled = "disabled";
			}
        }
        
       
//ファイル名非表示       
       const fileSelect = document.getElementById("fileSelect");
	   const fileElem = document.getElementById("fileElem");

fileSelect.addEventListener("click", (e) => {
  if (fileElem) {
    fileElem.click();
  }
}, false);