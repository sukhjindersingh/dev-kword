static function getCalendar() {
		$time = date ( 'Y-m-d' );
		if (function_exists ( 'date_default_timezone_set' )) {
			date_default_timezone_set ( 'PRC' );
		}
		$date = isset ( $_GET ['date'] ) ? $_GET ['date'] : $time;
		$date = getdate ( strtotime ( $date ) );
		$end = getdate ( mktime ( 0, 0, 0, $date ['mon'] + 1, 1, $date ['year'] ) - 1 );
		$start = getdate ( mktime ( 0, 0, 0, $date ['mon'], 1, $date ['year'] ) );		
		
		$arr_tpl = array (
				0 => '',
				1 => '',
				2 => '',
				3 => '',
				4 => '',
				5 => '',
				6 => '' 
		);
		$date_arr = array ();
		$j = 0;
		for($i = 0; $i < $end ['mday']; $i ++) {
			if (! isset ( $date_arr [$j] )) {
				$date_arr [$j] = $arr_tpl;
			}
			$date_arr [$j] [($i + $start ['wday']) % 7] = $i + 1;
			if ($date_arr [$j] [6]) {
				$j ++;
			}
		}
		foreach ( $date_arr as $value ) {
			$html .= "<div class='day'>";
			foreach ( $value as $v ) {
				if ($v > 9) {
					$vvv = $v;
				} else {
					$vvv = "0" . $v;
				}
				$datemm = $date ['year'] . '-' . $date ['mon'] . '-' . $vvv; // 2013-6-03
				
				$datemm = '0';
				
				if ($v) {
					if ($v == $date ['mday']) {
						$html .= '<span class=\'today\' style=\'background:#F1CA7F;\'><b>' . $vvv . '</b></span>';
					} else {
						$html .= '<span class=\'number\'>' . $vvv . '</span>';
					}
				} else {
					$html .= '<span class=\'nbsp\'>&nbsp;</span>';
				}
			}
			$html .= '</div>';
		}
		
		return $html;
	}