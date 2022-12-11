package com.kodego.app.studentassistaneappv20

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.app.studentassistaneappv20.databinding.StudentActivityBinding

class SubjectAdapter (val subjects: MutableList<Subjects>): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {


    var onItemClick: ((Subjects) -> Unit)? = null
    var onUpdateButtonClick: ((Subjects, Int) -> Unit)? = null
    var onDeleteButtonClick: ((Subjects, Int) -> Unit)? = null

    //create student activity xml
    inner class SubjectViewHolder(val binding: StudentActivityBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StudentActivityBinding.inflate(layoutInflater, parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {

        //holder.binding.imgProduct.setImageResource() << old method
        holder.binding.apply {
            imgSubject.setImageResource(subjects[position].imageSubject)
            tvSubjectName.text = subjects[position].subjectName
            tvSubjectDescription.text = subjects[position].subjectDescription
            tvSubjectNumber.text = subjects[position].subjectNumber.toString()
//            imgBtnUpdate.setOnClickListener(){
//                onUpdateButtonClick?.invoke(products[position],position)
//            }
//            imgBtnDelete.setOnClickListener(){
//                onDeleteButtonClick?.invoke(products[position],position)
//            }
        }
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(subjects[position])
        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

}