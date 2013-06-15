<?php
class module_util {
	static function getProperties() {
		global $_MODULE;
		
		$leve01_style01_items = $_MODULE ['leve01_style01_items'];
		$leve01_style01_i55nfo = $_MODULE ['leve01_style01_i55nfo'];
	}
	static function getCalendar() {
		$time = date ( 'Y-m-d' );
		
		if (function_exists ( 'date_default_timezone_set' )) {
			date_default_timezone_set ( 'PRC' );
		}
		
		$date = isset ( $_GET ['date'] ) ? $_GET ['date'] : $time;
		$date = getdate ( strtotime ( $date ) );
		$end = getdate ( mktime ( 0, 0, 0, $date ['mon'] + 1, 1, $date ['year'] ) - 1 ); //
		$start = getdate ( mktime ( 0, 0, 0, $date ['mon'], 1, $date ['year'] ) ); // 获取 当前月
		
		$arr_tpl = array (
				0 => '',
				1 => '',
				2 => '',
				3 => '',
				4 => '',
				5 => '',
				6 => '' 
		);
		$date_array = array ();
		
		/* -------------prve year--------------- */
		$prve_year = getdate ( mktime ( 0, 0, 0, $date ['mon'], 1, $date ['year'] ) - 1 ); // 取上一个月的日期
		
		$prve_year_end = $prve_year ['mday']; // 取得上一月最后一天的日期
		$prve_wday_end = $prve_year ['wday']; // 取得上一月 最后一天结束在星期几
		
		$prve_day = $prve_year_end - $prve_wday_end; // 计算差值
		
		$is_one_set = true;
		
		/* ------------today year------------------ */
		$today_year = getdate ( mktime ( 0, 0, 0, $date ['mon'] + 1, 1, $date ['year'] ) + 1 ); // 去下一个月的日期
		$today_wday_end = $today_year ['wday']; //
		$is_tow_set = true;
		
		/* ------------------------------ */
		
		$j = 0;
		
		for($i = 0; $i < $end ['mday']; $i ++) { // 循环 输出 日期。日期数字小于当前月的最大天数 $end ['mday']
			if (! isset ( $date_array [$j] )) { // $date_array 二维数组 一维存储一个实例化过的空数组 方便遍历输出每7天为一个星期的 日期数组
				$date_array [$j] = $arr_tpl;
			}
			
			/**
			 * 设置 上月还剩下的日期 *
			 */
			if ($is_one_set) { // 设置 上月还剩下的日期
				$_j = 0;
				for($prve_i = $prve_day; $prve_i <= $prve_year_end; $prve_i ++) {
					
					$date_array [$j] [$_j] = '99' . $prve_i; // 将取值加99 方便下面判断和现实效果 加上 不同的 Class
					$_j ++;
				}
				$is_one_set = false;
			}
			/**
			 * 设置 上月还剩下的日期 end *
			 */
			
			$date_array [$j] [($i + $start ['wday']) % 7] = $i + 1; // 取得 本月 开始日期对应的 星期 $start ['wday']
			
			if ($date_array [$j] [6]) {
				$j ++;
			}
		}
		;
		/**
		 * 设置下月显示的日期
		 */
		for($i = 0; $i < 7 - $today_wday_end; $i ++) { // 设置下月显示的日期
			$date_array [$j] [($today_wday_end + $i)] = '99' . ($i + 1); // 取得 本月 开始日期对应的 星期 $start ['wday']
		}
		/**
		 * 设置下月显示的日期 end
		 */
		foreach ( $date_array as $value ) {
			
			$html .= "<div class='day'>";
			
			foreach ( $value as $v ) {
				
				$v = $v > 9 ? $v : '0' . $v; // 取 当日期小于10时在前面补零效果
				
				$dateTem = $date ['year'] . '-' . $date ['mon'] . '-' . $v; // 2013-6-03
				if ($v) {
					if ($v == $date ['mday']) { // 当天日期 设置颜色
						$html .= '<span class=\'today\' ><b>' . $v . '</b></span>';
					} else if ($v > 99) { // 这里设置 上下月的日期 不要就把 $tem_v 变量注销掉
						
						$tem_ = str_replace ( "99", "", $v );
						$tem_v = $tem_ > 10 ? $tem_ : '0' . $tem_;
						$html .= '<span class=\'otherDay\'>' . $tem_v . '</span>';
					} else {
						$html .= '<span class=\'number\'>' . $v . '</span>';
					}
				} else {
					$html .= '<span class=\'nbsp\'>&nbsp;</span>';
				}
			}
			$html .= '</div>';
		}
		return $html;
	}
}
class util {
	static function getPut($str) {
		$html_reg = "/(<[^>]*>)/";
		$img_reg = "/^https?://.+/.+\\.(jpg|gif|png|jpeg)$/i";
		
		$tem_content = "";
		
		if (null != $str && ! empty ( $str )) {
			
			if (preg_match ( $html_reg, $str )) {
				return $str;
			} else if (preg_match_all ( $img_reg, $str )) {
				
				if (strstr ( $str, "|" )) {
					// $array_tem = str_split ( $str,"|" );
					// foreach ( $array_tem as $list ) {
					// $tem_content =$tem_content. "<img src='" . $list . "' />";
					// }
				} else {
					$tem_content = $tem_content . "<img src='" . $str . "' />";
				}
				return $tem_content;
			} else {
				return $str;
			}
		} else {
			return "";
		}
	}
	static function getStr($var) {
		if (is_integer ( $var )) {
			
			return $var * 3;
		}
		
		return 'No integer..';
	}
	static function getDom($item) {
		if (null != $item) {
			
			$item = <<<html
		
		<div style="border:1px solid red;color:$item">$item</div>

html;
			
			echo $item;
		} else {
			echo "no";
		}
	}
	static function getIndexAnims($obj) {
		global $_MODULE;
		/**
		 * ****************************************
		 */
		$Abackground = $_MODULE ['Abackground'];
		
		$Aa1StartXY = $_MODULE ['Aa1StartXY'];
		$Aa1OnXY = $_MODULE ['Aa1OnXY'];
		$Aa2StartOpacity = $_MODULE ['Aa2StartOpacity'];
		$Aa2OntOpacity = $_MODULE ['Aa2OntOpacity'];
		$Aa3StartZoom = $_MODULE ['Aa3StartZoom'];
		$Aa3OnZoom = $_MODULE ['Aa3OnZoom'];
		$Aa4StartTilt = $_MODULE ['Aa4StartTilt'];
		$Aa4OnTilt = $_MODULE ['Aa4OnTilt'];
		$Aa5StartRotate = $_MODULE ['Aa5StartRotate'];
		$Aa5OnRotate = $_MODULE ['Aa5OnRotate'];
		$AaEase = $_MODULE ['AaEase'];
		$Aa1AnimTime = $_MODULE ['Aa1AnimTime'];
		// //////////////////////////////////////////////////
		
		$Ab1StartXY = $_MODULE ['Ab1StartXY'];
		$Ab1OnXY = $_MODULE ['Ab1OnXY'];
		$Ab2StartOpacity = $_MODULE ['Ab2StartOpacity'];
		$Ab2OntOpacity = $_MODULE ['Ab2OntOpacity'];
		$Ab3StartZoom = $_MODULE ['Ab3StartZoom'];
		$Ab3OnZoom = $_MODULE ['Ab3OnZoom'];
		$Ab4StartTilt = $_MODULE ['Ab4StartTilt'];
		$Ab4OnTilt = $_MODULE ['Ab4OnTilt'];
		$Ab5StartRotate = $_MODULE ['Ab5StartRotate'];
		$Ab5OnRotate = $_MODULE ['Ab5OnRotate'];
		$AbEase = $_MODULE ['AbEase'];
		$Ab1AnimTime = $_MODULE ['Ab1AnimTime'];
		// //////////////////////////////////////////////////
		
		$Ac1StartXY = $_MODULE ['Ab1StartXY'];
		$Ac1OnXY = $_MODULE ['Ab1OnXY'];
		$Ac2StartOpacity = $_MODULE ['Ac2StartOpacity'];
		$Ac2OntOpacity = $_MODULE ['Ac2OntOpacity'];
		$Ac3StartZoom = $_MODULE ['Ac3StartZoom'];
		$Ac3OnZoom = $_MODULE ['Ac3OnZoom'];
		$Ac4StartTilt = $_MODULE ['Ac4StartTilt'];
		$Ac4OnTilt = $_MODULE ['Ac4OnTilt'];
		$Ac5StartRotate = $_MODULE ['Ac5StartRotate'];
		$Ac5OnRotate = $_MODULE ['Ac5OnRotate'];
		$AcEase = $_MODULE ['AcEase'];
		$Ac1AnimTime = $_MODULE ['Ac1AnimTime'];
		// //////////////////////////////////////////////////
		
		$Ad1StartXY = $_MODULE ['Ad1StartXY'];
		$Ad1OnXY = $_MODULE ['Ad1OnXY'];
		$Ad2StartOpacity = $_MODULE ['Ad2StartOpacity'];
		$Ad2OntOpacity = $_MODULE ['Ad2OntOpacity'];
		$Ad3StartZoom = $_MODULE ['Ad3StartZoom'];
		$Ad3OnZoom = $_MODULE ['Ad3OnZoom'];
		$Ad4StartTilt = $_MODULE ['Ad4StartTilt'];
		$Ad4OnTilt = $_MODULE ['Ad4OnTilt'];
		$Ad5StartRotate = $_MODULE ['Ad5StartRotate'];
		$Ad5OnRotate = $_MODULE ['Ad5OnRotate'];
		$AdEase = $_MODULE ['AdEase'];
		$Ad1AnimTime = $_MODULE ['Ad1AnimTime'];
		/**
		 * ************************1111111111111*********************
		 */
		/**
		 * ****************************************
		 */
		$Bbackground = $_MODULE ['Bbackground'];
		
		$Ba1StartXY = $_MODULE ['Ba1StartXY'];
		$Ba1OnXY = $_MODULE ['Ba1OnXY'];
		$Ba2StartOpacity = $_MODULE ['Ba2StartOpacity'];
		$Ba2OntOpacity = $_MODULE ['Ba2OntOpacity'];
		$Ba3StartZoom = $_MODULE ['Ba3StartZoom'];
		$Ba3OnZoom = $_MODULE ['Ba3OnZoom'];
		$Ba4StartTilt = $_MODULE ['Ba4StartTilt'];
		$Ba4OnTilt = $_MODULE ['Ba4OnTilt'];
		$Ba5StartRotate = $_MODULE ['Ba5StartRotate'];
		$Ba5OnRotate = $_MODULE ['Ba5OnRotate'];
		$BaEase = $_MODULE ['BaEase'];
		$Ba1BnimTime = $_MODULE ['Ba1BnimTime'];
		// //////////////////////////////////////////////////
		
		$Bb1StartXY = $_MODULE ['Bb1StartXY'];
		$Bb1OnXY = $_MODULE ['Bb1OnXY'];
		$Bb2StartOpacity = $_MODULE ['Bb2StartOpacity'];
		$Bb2OntOpacity = $_MODULE ['Bb2OntOpacity'];
		$Bb3StartZoom = $_MODULE ['Bb3StartZoom'];
		$Bb3OnZoom = $_MODULE ['Bb3OnZoom'];
		$Bb4StartTilt = $_MODULE ['Bb4StartTilt'];
		$Bb4OnTilt = $_MODULE ['Bb4OnTilt'];
		$Bb5StartRotate = $_MODULE ['Bb5StartRotate'];
		$Bb5OnRotate = $_MODULE ['Bb5OnRotate'];
		$BbEase = $_MODULE ['BbEase'];
		$Bb1BnimTime = $_MODULE ['Bb1BnimTime'];
		// //////////////////////////////////////////////////
		
		$Bc1StartXY = $_MODULE ['Bb1StartXY'];
		$Bc1OnXY = $_MODULE ['Bb1OnXY'];
		$Bc2StartOpacity = $_MODULE ['Bc2StartOpacity'];
		$Bc2OntOpacity = $_MODULE ['Bc2OntOpacity'];
		$Bc3StartZoom = $_MODULE ['Bc3StartZoom'];
		$Bc3OnZoom = $_MODULE ['Bc3OnZoom'];
		$Bc4StartTilt = $_MODULE ['Bc4StartTilt'];
		$Bc4OnTilt = $_MODULE ['Bc4OnTilt'];
		$Bc5StartRotate = $_MODULE ['Bc5StartRotate'];
		$Bc5OnRotate = $_MODULE ['Bc5OnRotate'];
		$BcEase = $_MODULE ['BcEase'];
		$Bc1BnimTime = $_MODULE ['Bc1BnimTime'];
		// //////////////////////////////////////////////////
		
		$Bd1StartXY = $_MODULE ['Bd1StartXY'];
		$Bd1OnXY = $_MODULE ['Bd1OnXY'];
		$Bd2StartOpacity = $_MODULE ['Bd2StartOpacity'];
		$Bd2OntOpacity = $_MODULE ['Bd2OntOpacity'];
		$Bd3StartZoom = $_MODULE ['Bd3StartZoom'];
		$Bd3OnZoom = $_MODULE ['Bd3OnZoom'];
		$Bd4StartTilt = $_MODULE ['Bd4StartTilt'];
		$Bd4OnTilt = $_MODULE ['Bd4OnTilt'];
		$Bd5StartRotate = $_MODULE ['Bd5StartRotate'];
		$Bd5OnRotate = $_MODULE ['Bd5OnRotate'];
		$BdEase = $_MODULE ['BdEase'];
		$Bd1BnimTime = $_MODULE ['Bd1BnimTime'];
		/**
		 * ************************1111111111111*********************
		 */
		/**
		 * ****************************************
		 */
		$Cbackground = $_MODULE ['Cbackground'];
		
		$Ca1StartXY = $_MODULE ['Ca1StartXY'];
		$Ca1OnXY = $_MODULE ['Ca1OnXY'];
		$Ca2StartOpacity = $_MODULE ['Ca2StartOpacity'];
		$Ca2OntOpacity = $_MODULE ['Ca2OntOpacity'];
		$Ca3StartZoom = $_MODULE ['Ca3StartZoom'];
		$Ca3OnZoom = $_MODULE ['Ca3OnZoom'];
		$Ca4StartTilt = $_MODULE ['Ca4StartTilt'];
		$Ca4OnTilt = $_MODULE ['Ca4OnTilt'];
		$Ca5StartRotate = $_MODULE ['Ca5StartRotate'];
		$Ca5OnRotate = $_MODULE ['Ca5OnRotate'];
		$CaEase = $_MODULE ['CaEase'];
		$Ca1CnimTime = $_MODULE ['Ca1CnimTime'];
		// //////////////////////////////////////////////////
		
		$Cb1StartXY = $_MODULE ['Cb1StartXY'];
		$Cb1OnXY = $_MODULE ['Cb1OnXY'];
		$Cb2StartOpacity = $_MODULE ['Cb2StartOpacity'];
		$Cb2OntOpacity = $_MODULE ['Cb2OntOpacity'];
		$Cb3StartZoom = $_MODULE ['Cb3StartZoom'];
		$Cb3OnZoom = $_MODULE ['Cb3OnZoom'];
		$Cb4StartTilt = $_MODULE ['Cb4StartTilt'];
		$Cb4OnTilt = $_MODULE ['Cb4OnTilt'];
		$Cb5StartRotate = $_MODULE ['Cb5StartRotate'];
		$Cb5OnRotate = $_MODULE ['Cb5OnRotate'];
		$CbEase = $_MODULE ['CbEase'];
		$Cb1CnimTime = $_MODULE ['Cb1CnimTime'];
		// //////////////////////////////////////////////////
		
		$Cc1StartXY = $_MODULE ['Cb1StartXY'];
		$Cc1OnXY = $_MODULE ['Cb1OnXY'];
		$Cc2StartOpacity = $_MODULE ['Cc2StartOpacity'];
		$Cc2OntOpacity = $_MODULE ['Cc2OntOpacity'];
		$Cc3StartZoom = $_MODULE ['Cc3StartZoom'];
		$Cc3OnZoom = $_MODULE ['Cc3OnZoom'];
		$Cc4StartTilt = $_MODULE ['Cc4StartTilt'];
		$Cc4OnTilt = $_MODULE ['Cc4OnTilt'];
		$Cc5StartRotate = $_MODULE ['Cc5StartRotate'];
		$Cc5OnRotate = $_MODULE ['Cc5OnRotate'];
		$CcEase = $_MODULE ['CcEase'];
		$Cc1CnimTime = $_MODULE ['Cc1CnimTime'];
		// //////////////////////////////////////////////////
		
		$Cd1StartXY = $_MODULE ['Cd1StartXY'];
		$Cd1OnXY = $_MODULE ['Cd1OnXY'];
		$Cd2StartOpacity = $_MODULE ['Cd2StartOpacity'];
		$Cd2OntOpacity = $_MODULE ['Cd2OntOpacity'];
		$Cd3StartZoom = $_MODULE ['Cd3StartZoom'];
		$Cd3OnZoom = $_MODULE ['Cd3OnZoom'];
		$Cd4StartTilt = $_MODULE ['Cd4StartTilt'];
		$Cd4OnTilt = $_MODULE ['Cd4OnTilt'];
		$Cd5StartRotate = $_MODULE ['Cd5StartRotate'];
		$Cd5OnRotate = $_MODULE ['Cd5OnRotate'];
		$CdEase = $_MODULE ['CdEase'];
		$Cd1CnimTime = $_MODULE ['Cd1CnimTime'];
		/**
		 * ************************1111111111111*********************
		 */
		/**
		 * ****************************************
		 */
		$Dbackground = $_MODULE ['Dbackground'];
		
		$Da1StartXY = $_MODULE ['Da1StartXY'];
		$Da1OnXY = $_MODULE ['Da1OnXY'];
		$Da2StartOpacity = $_MODULE ['Da2StartOpacity'];
		$Da2OntOpacity = $_MODULE ['Da2OntOpacity'];
		$Da3StartZoom = $_MODULE ['Da3StartZoom'];
		$Da3OnZoom = $_MODULE ['Da3OnZoom'];
		$Da4StartTilt = $_MODULE ['Da4StartTilt'];
		$Da4OnTilt = $_MODULE ['Da4OnTilt'];
		$Da5StartRotate = $_MODULE ['Da5StartRotate'];
		$Da5OnRotate = $_MODULE ['Da5OnRotate'];
		$DaEase = $_MODULE ['DaEase'];
		$Da1DnimTime = $_MODULE ['Da1DnimTime'];
		// //////////////////////////////////////////////////
		
		$Db1StartXY = $_MODULE ['Db1StartXY'];
		$Db1OnXY = $_MODULE ['Db1OnXY'];
		$Db2StartOpacity = $_MODULE ['Db2StartOpacity'];
		$Db2OntOpacity = $_MODULE ['Db2OntOpacity'];
		$Db3StartZoom = $_MODULE ['Db3StartZoom'];
		$Db3OnZoom = $_MODULE ['Db3OnZoom'];
		$Db4StartTilt = $_MODULE ['Db4StartTilt'];
		$Db4OnTilt = $_MODULE ['Db4OnTilt'];
		$Db5StartRotate = $_MODULE ['Db5StartRotate'];
		$Db5OnRotate = $_MODULE ['Db5OnRotate'];
		$DbEase = $_MODULE ['DbEase'];
		$Db1DnimTime = $_MODULE ['Db1DnimTime'];
		// //////////////////////////////////////////////////
		
		$Dc1StartXY = $_MODULE ['Db1StartXY'];
		$Dc1OnXY = $_MODULE ['Db1OnXY'];
		$Dc2StartOpacity = $_MODULE ['Dc2StartOpacity'];
		$Dc2OntOpacity = $_MODULE ['Dc2OntOpacity'];
		$Dc3StartZoom = $_MODULE ['Dc3StartZoom'];
		$Dc3OnZoom = $_MODULE ['Dc3OnZoom'];
		$Dc4StartTilt = $_MODULE ['Dc4StartTilt'];
		$Dc4OnTilt = $_MODULE ['Dc4OnTilt'];
		$Dc5StartRotate = $_MODULE ['Dc5StartRotate'];
		$Dc5OnRotate = $_MODULE ['Dc5OnRotate'];
		$DcEase = $_MODULE ['DcEase'];
		$Dc1DnimTime = $_MODULE ['Dc1DnimTime'];
		// //////////////////////////////////////////////////
		
		$Dd1StartXY = $_MODULE ['Dd1StartXY'];
		$Dd1OnXY = $_MODULE ['Dd1OnXY'];
		$Dd2StartOpacity = $_MODULE ['Dd2StartOpacity'];
		$Dd2OntOpacity = $_MODULE ['Dd2OntOpacity'];
		$Dd3StartZoom = $_MODULE ['Dd3StartZoom'];
		$Dd3OnZoom = $_MODULE ['Dd3OnZoom'];
		$Dd4StartTilt = $_MODULE ['Dd4StartTilt'];
		$Dd4OnTilt = $_MODULE ['Dd4OnTilt'];
		$Dd5StartRotate = $_MODULE ['Dd5StartRotate'];
		$Dd5OnRotate = $_MODULE ['Dd5OnRotate'];
		$DdEase = $_MODULE ['DdEase'];
		$Dd1DnimTime = $_MODULE ['Dd1DnimTime'];
		/**
		 * ************************1111111111111*********************
		 */
		
		echo $Aa1AnimTime . "  " . $Aa1OnXY . "  " . $Aa1StartXY . "  " . $Aa2OntOpacity . "   " . $Aa2StartOpacity . "  " . $Aa3OnZoom . "  " . $Aa3StartZoom . "  " . $Aa4OnTilt . "  " . $Aa4StartTilt . "  " . $Aa5StartRotate . "   " . $AaEase . "  " . $Abackground . " ";
	}
}

?>