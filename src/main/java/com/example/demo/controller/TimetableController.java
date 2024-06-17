package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.History;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.LessonTextbook;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.Timetable;
import com.example.demo.model.Account;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.LessonRepository;
import com.example.demo.repository.LessonTextbookRepository;
import com.example.demo.repository.TextbookRepository;
import com.example.demo.repository.TimetableRepository;

@Controller
public class TimetableController {

	@Autowired
	Account account;

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	LessonTextbookRepository lessonTextbookRepository;

	@Autowired
	TimetableRepository timetableRepository;

	//時間割追加画面の表示
	@GetMapping("/account/addTimatabel")
	public String addTimatabel(
			@RequestParam(name = "day") Integer day,
			@RequestParam(name = "period") Integer period,
			Model model) {

		List<Lesson> lessons = lessonRepository.findByDayAndPeriod(day, period);

		model.addAttribute("lessons", lessons);

		return "addTimetable";
	}

	//時間割追加処理
	@PostMapping("/account/addTimatabel")
	public String sendTimatabel(@RequestParam(name = "lessonId", defaultValue = "") Integer lessonId) {

		Timetable timetable = new Timetable(lessonId, account.getId());
		timetableRepository.save(timetable);

		List<LessonTextbook> lessonTextbooks = lessonTextbookRepository.findByLessonId(lessonId);
		for (LessonTextbook lessonTextbook : lessonTextbooks) {
			History history = historyRepository.findOneByTextbookIdAndUserId(lessonTextbook.getTextbookId(),
					account.getId());
			if (history == null) {
				history = new History(lessonTextbook.getTextbookId(), account.getId(), 1);
				historyRepository.save(history);
			}
		}

		return "redirect:/account";
	}

	//授業詳細画面の表示
	@GetMapping("/account/viewTimatabel")
	public String viewTimatabel(
			@RequestParam(name = "lessonId") Integer lessonId,
			Model model) {

		Timetable timetable = timetableRepository.findOneByLessonIdAndUserId(lessonId, account.getId());

		Lesson lesson = lessonRepository.findOneById(timetable.getLessonId());

		List<LessonTextbook> lessonTextbooks = lessonTextbookRepository.findByLessonId(timetable.getLessonId());

		List<Textbook> textbooks = new ArrayList<Textbook>();

		List<History> histories = new ArrayList<History>();

		for (LessonTextbook lessonTextbook : lessonTextbooks) {
			textbooks.add(textbookRepository.findOneById(lessonTextbook.getTextbookId()));
			histories.add(
					historyRepository.findOneByTextbookIdAndUserId(lessonTextbook.getTextbookId(), account.getId()));
		}

		model.addAttribute("timetable", timetable);
		model.addAttribute("lesson", lesson);
		model.addAttribute("textbooks", textbooks);
		model.addAttribute("histories", histories);

		return "viewTimetable";
	}

	//時間割変更画面の表示
	@GetMapping("/account/setTimetable")
	public String setTimetable(
			@RequestParam(name = "timetableId") Integer timetableId,
			Model model) {

		Timetable timetable = timetableRepository.findOneById(timetableId);

		Lesson lesson = lessonRepository.findOneById(timetable.getLessonId());

		List<Lesson> lessons = lessonRepository.findByDayAndPeriod(lesson.getDay(), lesson.getPeriod());

		model.addAttribute("timetable", timetable);
		model.addAttribute("lesson", lesson);
		model.addAttribute("lessons", lessons);

		return "setTimetable";
	}

	//時間割変更処理
	@PostMapping("/account/setTimetable")
	public String resetTimetable(
			@RequestParam(name = "lessonId") Integer lessonId,
			@RequestParam(name = "timetableId") Integer timetableId) {
		Timetable timetable = timetableRepository.findOneById(timetableId);

		//指定された授業と今まで登録していた授業が異なる場合
		if (timetable.getLessonId() != lessonId) {
			//今までの授業を取得
			Lesson lesson = lessonRepository.findOneById(timetable.getLessonId());
			//今までの授業で用いていた教科書の一覧を取得
			List<LessonTextbook> lessonTextbooks = lessonTextbookRepository.findByLessonId(lesson.getId());

			//教科書が１冊以上の場合
			if (lessonTextbooks.size() > 0) {
				//教科書1冊ずつを処理
				for (LessonTextbook lessonTextbook : lessonTextbooks) {
					//教科書の購入履歴を取得
					History history = historyRepository.findOneByTextbookIdAndUserId(lessonTextbook.getTextbookId(),
							account.getId());
					//未購入の場合
					if (history.getStatus() == 1) {
						//変更前授業以外で同じ教科書を用いている授業の数
						int count = 0;

						//ログインユーザーの受講している時間割をすべて取得
						List<Timetable> timetables = timetableRepository.findByUserId(account.getId());

						List<Lesson> lessons = new ArrayList<Lesson>();
						//時間割1つずつを処理
						for (Timetable timeTable : timetables) {
							//時間割を授業にコンバート
							lessons.add(lessonRepository.findOneById(timeTable.getLessonId()));
						}

						//授業を1つずつ処理
						for (Lesson l : lessons) {
							//処理を行う授業が今まで登録していた授業と異なる場合
							if (l.getId() != lesson.getId()) {
								//授業で用いる教科書を格納
								List<LessonTextbook> lts = lessonTextbookRepository.findByLessonId(l.getId());
								//教科書が1冊以上の場合
								if (lts.size() > 0) {
									//教科書１冊ずつを処理
									for (LessonTextbook lt : lts) {
										//変更前の授業と同じ教科書を用いている場合
										if (lt.getTextbookId() == lessonTextbook.getTextbookId())
											//カウントを１つ追加
											count++;
									}
								}
							}
						}

						//変更前授業以外で同じ教科書を用いている授業がない場合
						if (count == 0)
							//購入履歴を削除する
							historyRepository.delete(history);
					}
				}
			}

			//時間割の授業IDを上書き保存
			timetable.setLessonId(lessonId);
			timetableRepository.save(timetable);

			//新しい授業で用いる教科書一覧を取得
			lessonTextbooks = lessonTextbookRepository.findByLessonId(lessonId);
			//教科書1冊ずつを処理
			for (LessonTextbook lessonTextbook : lessonTextbooks) {
				//同じ教科書の購入履歴を検索
				History history = historyRepository.findOneByTextbookIdAndUserId(lessonTextbook.getTextbookId(),
						account.getId());
				//購入履歴が存在しない場合
				if (history == null) {
					//購入履歴を新規作成＆保存
					history = new History(lessonTextbook.getTextbookId(), account.getId(), 1);
					historyRepository.save(history);
				}
			}
		}

		return "redirect:/account";
	}

	//時間割削除処理
	@PostMapping("/account/deleteTimetable")
	public String deleteTimetable(@RequestParam(name = "timetableId") Integer timetableId) {

		Timetable timetable = timetableRepository.findOneById(timetableId);

		//削除授業を取得
		Lesson lesson = lessonRepository.findOneById(timetable.getLessonId());
		//削除授業で用いていた教科書の一覧を取得
		List<LessonTextbook> lessonTextbooks = lessonTextbookRepository.findByLessonId(lesson.getId());

		//教科書が１冊以上の場合
		if (lessonTextbooks.size() > 0) {
			//教科書1冊ずつを処理
			for (LessonTextbook lessonTextbook : lessonTextbooks) {
				//教科書の購入履歴を取得
				History history = historyRepository.findOneByTextbookIdAndUserId(lessonTextbook.getTextbookId(),
						account.getId());
				//未購入の場合
				if (history.getStatus() == 1) {
					//変更前授業以外で同じ教科書を用いている授業の数
					int count = 0;

					//ログインユーザーの受講している時間割をすべて取得
					List<Timetable> timetables = timetableRepository.findByUserId(account.getId());

					List<Lesson> lessons = new ArrayList<Lesson>();
					//時間割1つずつを処理
					for (Timetable timeTable : timetables) {
						//時間割を授業にコンバート
						lessons.add(lessonRepository.findOneById(timeTable.getLessonId()));
					}

					//授業を1つずつ処理
					for (Lesson l : lessons) {
						//処理を行う授業が今まで登録していた授業と異なる場合
						if (l.getId() != lesson.getId()) {
							//授業で用いる教科書を格納
							List<LessonTextbook> lts = lessonTextbookRepository.findByLessonId(l.getId());
							//教科書が1冊以上の場合
							if (lts.size() > 0) {
								//教科書１冊ずつを処理
								for (LessonTextbook lt : lts) {
									//変更前の授業と同じ教科書を用いている場合
									if (lt.getTextbookId() == lessonTextbook.getTextbookId())
										//カウントを１つ追加
										count++;
								}
							}
						}
					}

					//削除授業以外で同じ教科書を用いている授業がない場合
					if (count == 0)
						//購入履歴を削除する
						historyRepository.delete(history);
				}
			}
		}

		//時間割を削除
		timetableRepository.delete(timetable);

		return "redirect:/account";
	}

	//購入履歴変更処理
	@PostMapping("/account/setHistory/{id}")
	public String setHistory(
			@PathVariable("id") Integer historyId,
			@RequestParam("timetableId") Integer timetableId) {
		History history = historyRepository.findOneById(historyId);
		
		Timetable timetable = timetableRepository.findOneById(timetableId);

		if (history.getStatus() == 1) {
			history.setStatus(2);
		} else {
			history.setStatus(1);
		}

		historyRepository.save(history);

		return "redirect:/account/viewTimatabel?lessonId=" + timetable.getLessonId();
	}

}
